package ru.rsatu.trade.service.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.trade.data.dto.good.GoodCreateRequestDto;
import ru.rsatu.trade.data.dto.good.GoodResponseDto;
import ru.rsatu.trade.data.dto.good.GoodUpdateRequestDto;
import ru.rsatu.trade.entity.Good;
import ru.rsatu.trade.mapper.GoodMapper;
import ru.rsatu.trade.service.GoodService;

@ApplicationScoped
public class GoodControllerService {

    @Inject
    GoodService goodService;

    @Inject
    GoodMapper goodMapper;

    @Transactional
    public GoodResponseDto createGood(GoodCreateRequestDto createRequestDto) {
        Good good = goodMapper.mapToGood(createRequestDto);
        goodService.createGood(good);
        return goodMapper.mapToResponse(good);
    }

    @Transactional
    public GoodResponseDto getGood(Long id) {
        Good good = goodService.getGood(id);
        return goodMapper.mapToResponse(good);
    }

    @Transactional
    public GoodResponseDto updateGood(Long id, GoodUpdateRequestDto updateRequestDto) {
        Good srcGood = goodMapper.mapToGood(updateRequestDto);
        goodService.updateGood(id, srcGood);
        Good good = goodService.getGood(id);
        return goodMapper.mapToResponse(good);
    }

    @Transactional
    public void deleteGood(Long id) {
        goodService.deleteGood(id);
    }
}
