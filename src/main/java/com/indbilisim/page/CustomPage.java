package com.indbilisim.page;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by semih on 09.02.2017.
 */
public class CustomPage {

    private Long total;

    private List rows;

    public CustomPage(Page page) {

        List list = page.getContent();
        for (int i = 0; i < list.size(); i++) {

        }
        this.rows = page.getContent();

        total = page.getTotalElements();
    }

    public List getRows() {

        return rows;
    }

    public void setRows(ArrayList rows) {

        this.rows = rows;
    }

    public Long getTotal() {

        return total;
    }

    public void setTotal(Long total) {

        this.total = total;
    }
}
