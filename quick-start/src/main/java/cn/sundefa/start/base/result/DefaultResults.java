package cn.sundefa.start.base.result;

import cn.sundefa.start.CodeMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * CodeMessage
 *
 * @author sundefa
 * @date 2018/12/13
 */
@AllArgsConstructor
@Getter
public enum DefaultResults implements CodeMessage {
    SUCCESS(1, "成功"),
    FAILURE(-1, "失败");
    private int code;
    private String message;
}
