/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services.impl;

import com.app.gestiondestock.dto.MvtStockDto;
import com.app.gestiondestock.exception.EntityNotFoundException;
import com.app.gestiondestock.exception.ErrorCodes;
import com.app.gestiondestock.exception.InvalidEntityException;
import com.app.gestiondestock.model.MvtStock;
import com.app.gestiondestock.repositories.MvtStockRepository;
import com.app.gestiondestock.services.IMvtStockService;
import com.app.gestiondestock.validator.MvtStockValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MvtStockServiceImpl implements IMvtStockService {

    MvtStockRepository mvtStockRepository;

    @Autowired
    public MvtStockServiceImpl(MvtStockRepository mvtStockRepository){
        this.mvtStockRepository = mvtStockRepository;
    }

    @Override
    public MvtStockDto save(MvtStockDto mvtStockDto) {
        List<String> errors = MvtStockValidator.validate(mvtStockDto);
        if(!errors.isEmpty()){
            log.error("Le mouvement est null");
            throw new InvalidEntityException("Le mouvement est null", ErrorCodes.MVT_STOCK_NOT_VALID);
        }
        return MvtStockDto.fromEntity(mvtStockRepository.save(MvtStockDto.toEntity(mvtStockDto)));

    }

    @Override
    public MvtStockDto findById(Integer id) {
        if( id == null){
            log.error("L'Id n'existe pas !");
            return null;
        }

        Optional<MvtStock> mvtStock = mvtStockRepository.findById(id);
        return Optional.of(MvtStockDto.fromEntity(mvtStock.get())).orElseThrow(() -> new EntityNotFoundException
                ("Le mouvement ayant l'ID : "+id+" n'existe pas !",ErrorCodes.MVT_STOCK_NOT_FOUND));
    }

    @Override
    public MvtStockDto findMvtStockByCode(String code) {
        if(code == null){
            log.error("L'Id n'existe pas !");
            return null;
        }

        Optional<MvtStock> mvtStock = mvtStockRepository.findByCode(code);
        return Optional.of(MvtStockDto.fromEntity(mvtStock.get())).orElseThrow(() -> new EntityNotFoundException
                ("Le mouvement ayant l'ID : "+code+" n'existe pas !",ErrorCodes.MVT_STOCK_NOT_FOUND));    }

    @Override
    public List<MvtStockDto> findAll() {
        return mvtStockRepository.findAll().stream().map(MvtStockDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if( id == null){
            log.error("L'ID n'existe pas !");
        }
        mvtStockRepository.deleteById(id);
    }
}
