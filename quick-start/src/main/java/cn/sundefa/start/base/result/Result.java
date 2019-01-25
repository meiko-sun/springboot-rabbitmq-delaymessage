package cn.sundefa.start.base.result;

import cn.sundefa.start.CodeMessage;
import cn.sundefa.start.base.interfaces.Executer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"result", "mes"})
public class Result<T> {
    public static final int SUCCESS_CODE = 1;
    public static final String SUCCESS_MSG = "成功";
    public static final int FAILURE_DEFAULT_CODE = 500;

    @Setter
    int code;

    @Getter
    @Setter
    String message;

    @Getter
    @Setter
    T data;

    @Getter
    String requestId;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> make() {
        return new Result(SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public static <T> Result<T> make(T data) {
        return new Result(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static <T> Result<T> make(T data, CodeMessage codeMessage) {
        return new Result(codeMessage.getCode(), codeMessage.getMessage(), data);
    }

    public static <T> Result<T> make(CodeMessage codeMessage) {
        return new Result(codeMessage.getCode(), codeMessage.getMessage(), null);
    }

    public static <T> Result<T> make(T data, Integer code, String message) {
        return new Result(code, message, data);
    }

    public static void main(String[] args) {
        Result result = Result.make("test");
        try {
            System.out.println(new ObjectMapper().writeValueAsString(result));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Deprecated

    public String getResult() {
        return this.code + "";
    }

    @Deprecated
    @JsonIgnore
    public String getMes() {
        return this.message;
    }

    public boolean success() {
        return this.code == SUCCESS_CODE;
    }

    @JsonIgnore
    public int getCode() {
        return this.code;
    }

    public void doWhen(Executer whenSuccess, Executer whenFailure) {
        if (success()) {
            if (null != whenSuccess) {
                whenSuccess.execute();
            }
        } else {
            if (null != whenFailure) {
                whenFailure.execute();
            }
        }
    }
}
