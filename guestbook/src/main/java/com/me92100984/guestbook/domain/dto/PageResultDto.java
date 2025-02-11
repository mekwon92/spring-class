package com.me92100984.guestbook.domain.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "dtoList")
public class PageResultDto<D, E> {
  private List<D> dtoList;

  private int totalPage;
  private int page, size;
  private int start, end;
  private boolean prev, next;

  private List<Integer> pageList;

  //function: entity입력 dto로 반환
  public PageResultDto(Page<E> result, Function<E, D> fn) {
    //Page<E>는 화면에서 결과적으로 List<D>가 필요하다,,
    dtoList = result.stream().map(fn).toList();
    totalPage = result.getTotalPages();

    Pageable pageable = result.getPageable();
    page = pageable.getPageNumber() + 1; //0부터시작하니까
    size = pageable.getPageSize();

    // 사과박스
    int tempEnd = (int)(Math.ceil(page / 10.0)) * 10;
    start = tempEnd - 9;
    prev = start > 1;

    end = totalPage > tempEnd ? tempEnd : totalPage;
    next = totalPage > tempEnd;

    pageList = IntStream.rangeClosed(start, end).boxed().toList();
  }
}
