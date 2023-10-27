package com.example.be.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchNhanVienRequest {
    private String maSearch;

    private String sdtSearch;

    private String diaChiSearch;

    private Integer pageNo = 0;
}
