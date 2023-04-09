package com.example.eidopdrachtnovi.dtos;

import jakarta.validation.constraints.NotNull;

public class DeelOpdrachtDigitalInputDto extends DeelOpdrachtInputDto{
    @NotNull(message = "Size is required")
    private String sizePX;
    private boolean animation;
    private String fileFormat;

    public String getSizePX() {
        return sizePX;
    }

    public void setSizePX(String sizePX) {
        this.sizePX = sizePX;
    }

    public boolean isAnimation() {
        return animation;
    }

    public void setAnimation(boolean animation) {
        this.animation = animation;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }
}
