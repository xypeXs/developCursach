package ru.rsatu.cursach.service.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ru.rsatu.cursach.data.dto.good.GoodCreateRequestDto;
import ru.rsatu.cursach.data.dto.good.GoodResponseDto;
import ru.rsatu.cursach.data.dto.good.GoodUpdateRequestDto;
import ru.rsatu.cursach.entity.Good;
import ru.rsatu.cursach.mapper.GoodMapper;
import ru.rsatu.cursach.service.GoodService;

@ApplicationScoped
public class GoodControllerService {

    @Inject
    GoodService goodService;

    @Inject
    GoodMapper goodMapper;

    public GoodResponseDto createGood(GoodCreateRequestDto createRequestDto) {
        Good good = goodMapper.mapToGood(createRequestDto);
        goodService.createGood(good);
        return goodMapper.mapToResponse(good);
    }

    public GoodResponseDto getGood(Long id) {
        Good good = goodService.getGood(id);
        return goodMapper.mapToResponse(good);
    }

    public GoodResponseDto updateGood(Long id, GoodUpdateRequestDto updateRequestDto) {
        Good srcGood = goodMapper.mapToGood(updateRequestDto);
        goodService.updateGood(id, srcGood);
        Good good = goodService.getGood(id);
        return goodMapper.mapToResponse(good);
    }

    public void deleteGood(Long id) {
        Good good = goodService.getGood(id);
        goodService.deleteGood(good);
    }
}
