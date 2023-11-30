package com.example.construction.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.construction.models.UniteMesure;
import com.example.construction.models.ZoneStock;
import com.example.construction.repositories.UniteMesureRepository;
import com.example.construction.repositories.ZoneStockRepository;
import javax.persistence.EntityNotFoundException;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ParametrageService {

    private final ZoneStockRepository zoneStockRepository;
    private final UniteMesureRepository uniteMesureRepository;

/// / //////////////////// ZONE //////////////////////////////////////////////////////////
    //AJOUT
    public ZoneStock addZone(ZoneStock zone) {
        try {
            zoneStockRepository.save(zone);
            return zone;
        } catch (Exception e) {
            throw e;
        }
    }

    //MODIFICATION
    public ZoneStock updateZone(ZoneStock updatedZone) {
        try {
            // Vérifier si la zone que vous souhaitez mettre à jour existe dans la base de données
            ZoneStock existingZone = zoneStockRepository.findById(updatedZone.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Zone not found with id: " + updatedZone.getId()));

            // Mettre à jour les propriétés de la zone existante avec les nouvelles valeurs
            existingZone.setDesignation(updatedZone.getDesignation());
            existingZone.setDescription(updatedZone.getDescription());

            // Enregistrer la mise à jour dans la base de données
            zoneStockRepository.save(existingZone);

            // Retourner la zone mise à jour
            return existingZone;
        } catch (Exception e) {
            // Gérer les exceptions, vous pouvez choisir de les logger ou de les relancer
            throw e;
        }
    }

    //Suppression
    public void softDeleteZone(Long zoneId) {
        ZoneStock existingZone = zoneStockRepository.findById(zoneId)
                .orElseThrow(() -> new EntityNotFoundException("Zone not found with id: " + zoneId));

        existingZone.softDelete(); // Utilisez la méthode de suppression logique définie dans l'entité
        zoneStockRepository.save(existingZone);
    }

    //LISTE
    public List<ZoneStock> getAllZone() {
        return zoneStockRepository.findAll();
    }

    /// / //////////////////// UNITE MESURE //////////////////////////////////////////////////////////
    
    //AJOUT
    public UniteMesure addUnite(UniteMesure uniteMesure) {
        try {
            uniteMesureRepository.save(uniteMesure);
            return uniteMesure;
        } catch (Exception e) {
            throw e;
        }
    }

    //MODIFICATION
    public UniteMesure updateUnite(UniteMesure uniteMesure) {
        try {
            // Vérifier si la zone que vous souhaitez mettre à jour existe dans la base de données
            UniteMesure existingUnite = uniteMesureRepository.findById(uniteMesure.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Unite not found with id: " + uniteMesure.getId()));

            // Mettre à jour les propriétés de la zone existante avec les nouvelles valeurs
            existingUnite.setNom(uniteMesure.getNom());
            existingUnite.setAbreviation(uniteMesure.getAbreviation());

            // Enregistrer la mise à jour dans la base de données
            uniteMesureRepository.save(existingUnite);

            // Retourner la zone mise à jour
            return existingUnite;
        } catch (Exception e) {
            // Gérer les exceptions, vous pouvez choisir de les logger ou de les relancer
            throw e;
        }
    }

    //Suppression
    public UniteMesure softDeleteUnite(Long uniteId) {
        UniteMesure existingUnite = uniteMesureRepository.findById(uniteId)
                .orElseThrow(() -> new EntityNotFoundException("Unite not found with id: " + uniteId));

        existingUnite.softDelete(); // Utilisez la méthode de suppression logique définie dans l'entité
        uniteMesureRepository.save(existingUnite);
        return existingUnite == null ? null : existingUnite;
    }

    //LISTE
    public List<UniteMesure> getAllUnite() {
        return uniteMesureRepository.findAll();
    }




}
