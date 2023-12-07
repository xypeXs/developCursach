package ru.rsatu.cursach.data.dto.reference;

import ru.rsatu.cursach.data.dto.base.BasePageDto;

import java.util.List;

public class BaseReferencePageDto extends BasePageDto<BaseReferenceDto> {

    public BaseReferencePageDto(List<BaseReferenceDto> content, Long total) {
        super(content, total);
    }

    public static BaseReferencePageDto empty() {
        return new BaseReferencePageDto(BasePageDto.empty());
    }

    private BaseReferencePageDto(BasePageDto<BaseReferenceDto> basePageDto) {
        super(basePageDto);
    }
}
