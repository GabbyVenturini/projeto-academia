package com.api.funcionario.entity.enums;

public enum PermissoesEnum {
    VISITANTE("visitante"),GERENTE("gerente"),ADMIN("admin");

    String permissao;

    PermissoesEnum(String permissao) {
        this.permissao = permissao;
    }
    public static PermissoesEnum PermissoesString(String permissao) {
        for (PermissoesEnum permissoes : values()) {
            if (permissoes.getPermissao().equals(permissao)) {
                return permissoes;
            }
        }
        return null;
    }

    public String getPermissao() {
        return permissao;
    }
}
