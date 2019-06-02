package com.zb.demo.service;

import com.zb.demo.bean.CompanyBean;

import java.util.List;

public interface SearchService {
    public List<CompanyBean> search(String content, Double pMinware, Double pMaxmare, Integer pEdu, Integer pExp, Integer pFrom, boolean pIsstu,
                                    Integer cGuimo, Integer cHangye);
}
