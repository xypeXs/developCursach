package ru.rsatu.cursach.data.dto.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasePageDto<T> {
    private List<T> content;
    private Long total;

    public BasePageDto(BasePageDto<T> basePageDto) {
        if (basePageDto == null)
            basePageDto = BasePageDto.empty();
        this.content = basePageDto.getContent();
        this.total = basePageDto.getTotal();
    }

    public static <T> BasePageDto<T> empty() {
        return new BasePageDto<>(new ArrayList<>(), 0L);
    }
}
