package org.example.inventoryclient.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized
@Builder
public class PagedResponse<T> {
    private List<T> content;
    private Pageable pageable;
    private Long totalPages;
    private Long totalElements;
    private Boolean last;
    private Long numberOfElements;
    private Long size;
    private Long number;
    private Pageable.Sort sort;
    private Boolean first;
    private Boolean empty;

    public List<T> getItems() {
        return content;
    }
}
