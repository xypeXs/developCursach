package ru.rsatu.cursach.controller.handler;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import ru.rsatu.cursach.data.dto.exception.BaseBusinessResponseDto;
import ru.rsatu.cursach.exception.BaseBusinessException;
import ru.rsatu.cursach.mapper.ExceptionHandlerMapper;

@Provider
public class BaseExceptionHandler implements ExceptionMapper<BaseBusinessException> {

    @Inject
    ExceptionHandlerMapper exceptionHandlerMapper;

    @Override
    public Response toResponse(BaseBusinessException e) {
        BaseBusinessResponseDto responseDto = exceptionHandlerMapper.mapToResponseDto(e);
        return createResponse(responseDto);
    }

    private Response createResponse(Object dto) {
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(dto)
                .build();
    }
}
