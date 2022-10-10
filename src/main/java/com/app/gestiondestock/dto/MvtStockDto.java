/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.dto;

import com.app.gestiondestock.model.MvtStock;
import com.app.gestiondestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MvtStockDto {

    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    private ArticleDto article;

    private TypeMvtStk typeMvt;

    public static MvtStockDto fromEntity(MvtStock mvtStock){
        if(mvtStock == null){
            return null;
        }
        return MvtStockDto.builder()
                .id(mvtStock.getId())
                .dateMvt(mvtStock.getDateMvt())
                .quantite(mvtStock.getQuantite())
                .article(ArticleDto.fromEntity(mvtStock.getArticle()))
                .typeMvt(mvtStock.getTypeMvt())
                .build();
    }

    public static MvtStock toEntity(MvtStockDto mvtStockDto){
        if (mvtStockDto == null){
            return null;
        }
        MvtStock mvtStock = new MvtStock();
        mvtStock.setId(mvtStockDto.getId());
        mvtStock.setDateMvt(mvtStockDto.getDateMvt());
        mvtStock.setQuantite(mvtStockDto.getQuantite());
        mvtStock.setArticle(ArticleDto.toEntity(mvtStockDto.getArticle()));
        mvtStock.setTypeMvt(mvtStock.getTypeMvt());
        return mvtStock;
    }
}
