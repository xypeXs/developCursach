package ru.rsatu.trade.controller.handler;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import ru.rsatu.trade.data.dto.exception.BaseBusinessResponseDto;
import ru.rsatu.trade.exception.BaseBusinessException;
import ru.rsatu.trade.mapper.ExceptionHandlerMapper;

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
