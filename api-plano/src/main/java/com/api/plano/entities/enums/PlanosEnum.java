package com.api.plano.entities.enums;

public enum PlanosEnum {
    BASICO("BASICO"),
    ESSENCIAL("ESSENCIAL"),
    OURO("OURO"),
    FUNCIONARIO("FUNCIONARIO");

    String planoEscolhido;

    PlanosEnum(String planoEscolhido){
        this.planoEscolhido = planoEscolhido;
    }

    public  static PlanosEnum planoEscolhido(String planoEscolhido){
        PlanosEnum[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3){
            PlanosEnum planosEnum = var1[var3];
            if (planosEnum.getPlanoEscolhido().equals(planoEscolhido)){
                return planosEnum;
            }
        }
        return null;
    }
    public String getPlanoEscolhido(){
        return planoEscolhido;
    }
    public void setPlanoEscolhido(String planoEscolhido){
        this.planoEscolhido = planoEscolhido;
    }
}
