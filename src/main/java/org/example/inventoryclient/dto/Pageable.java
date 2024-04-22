package org.example.inventoryclient.dto;

import lombok.Data;

@Data
public class Pageable {
    @Data
    public static class Sort {
        private Boolean unsorted;
        private Boolean sorted;
        private Boolean empty;
    }
    private Sort sort;
    private Long pageNumber;
    private Long pageSize;
    private Long offset;
    private Boolean paged;
    private Boolean unpaged;
}