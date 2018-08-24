package com.inmaytide.orbit.commons.exception;

import com.inmaytide.orbit.commons.exception.consts.ThrowableDefinition;

/**
 * The version property does not match while the data is going to modify or remove.
 *
 * @author Moss
 * @since September 3, 2017
 */
public class VersionMismatchedException extends ResponseException {

    private static final long serialVersionUID = -22605139663792344L;

    public VersionMismatchedException() {
        super(ThrowableDefinition.VERSION_MISMATCHED);
    }
}
