package ru.rsatu.trade.data.validation.group;

import jakarta.validation.groups.Default;

public interface ValidationGroup {
    interface Post extends Default {
    }
    interface Put extends Default {
    }
}
