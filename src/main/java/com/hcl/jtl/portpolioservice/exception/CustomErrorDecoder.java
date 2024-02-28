package com.hcl.jtl.portpolioservice.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import jakarta.ws.rs.BadRequestException;

public class CustomErrorDecoder implements ErrorDecoder{

	@Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400:
                return new BadRequestException();
            case 503:
                return new ServiceNotAvailableException("Serivce Api is unavailable");
            default:
                return new Exception("Exception while getting service details");
        }
    }
}
