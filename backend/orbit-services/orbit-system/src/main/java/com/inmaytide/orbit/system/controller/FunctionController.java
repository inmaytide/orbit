package com.inmaytide.orbit.system.controller;

import com.inmaytide.orbit.system.domain.Function;
import com.inmaytide.orbit.system.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class FunctionController {

    @Autowired
    private FunctionService service;

    @GetMapping("menus/{menuId}/functions")
    public Flux<Function> list(@PathVariable Long menuId) {
        return Flux.fromIterable(service.listByMenuId(menuId));
    }

    @PostMapping("menus/{menuId}/functions")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Function> create(@RequestBody @Validated Mono<Function> function, @PathVariable Long menuId) {
        return function.doOnSuccess(inst -> inst.setMenuId(menuId))
                .doOnSuccess(this::assertCodeNotExist)
                .map(service::save);
    }

    @DeleteMapping("/functions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Mono<Long> id) {
        id.subscribe(service::remove);
    }

    @PutMapping("/functions")
    public Mono<Function> update(@RequestBody @Validated Mono<Function> inst) {
        return inst.doOnSuccess(this::assertCodeNotExist).map(service::update);
    }

    private void assertCodeNotExist(Function func) {
        if (func.getCode() != null) {
            Assert.isTrue(!service.exist(func.getCode(), func.getId() == null ? -1L : func.getId()), "Code is existed");
        }
    }

}
