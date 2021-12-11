package dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserCommentDto {

    private Long userId;
    private String username;
    private String productName;
    private String comment;
    private Date commentDate;
}
