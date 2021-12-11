package uygulamalar;

import dto.ProductCommentDto;
import dto.UserCommentDto;
import entity.Product;
import entityservice.ProductCommentEntityService;
import entityservice.ProductEntityService;

import java.util.List;
import java.util.stream.Collectors;

public class CommentsOfOneUserApp {

    public static void main(String[] args) {

        final List<UserCommentDto> userCommentDtoList = commensOfOneUser(1L);

    }

    public static List<UserCommentDto> commensOfOneUser(Long userId) {
        final ProductCommentEntityService productCommentEntityService = new ProductCommentEntityService();
        return productCommentEntityService.findByUserId(userId);
    }
}
