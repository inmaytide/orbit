package eureka

import (
	"crypto/tls"
	"log"
	"net/http"
	"strings"
)

func DoHttpRequest(action HttpAction) bool {
	request := buildHttpRequest(action)

	var defaultTransport http.RoundTripper = &http.Transport{
		TLSClientConfig: &tls.Config{InsecureSkipVerify: true},
	}

	response, err := defaultTransport.RoundTrip(request)

	if err != nil {
		log.Printf("Http request failed: %s", err)
	} else {
		return true
		defer response.Body.Close()
	}

	return false
}

func buildHttpRequest(action HttpAction) *http.Request {
	var request *http.Request
	var err error

	if action.Body != "" {
		reader := strings.NewReader(action.Body)
		request, err = http.NewRequest(action.Method, action.URL, reader)
	} else if action.Template != "" {
		reader := strings.NewReader(action.Template)
		request, err = http.NewRequest(action.Method, action.URL, reader)
	} else {
		request, err = http.NewRequest(action.Method, action.URL, nil)
	}

	if err != nil {
		log.Fatal(err)
	}

	request.Header.Add("Accept", action.Accept)
	if action.ContentType != "" {
		request.Header.Add("Content-Type", action.ContentType)
	}

	return request
}