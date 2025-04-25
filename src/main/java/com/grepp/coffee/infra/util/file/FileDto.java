package com.grepp.coffee.infra.util.file;

public record FileDto(
    String originFileName,
    String renameFileName,
    String savePath
) {

}
