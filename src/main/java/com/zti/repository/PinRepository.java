package com.zti.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zti.model.Pin;

import java.util.List;

@Repository
public interface PinRepository extends JpaRepository<Pin, Integer> {
    List<Pin> findByCategory(String category);
    List<Pin> findByCreatorUid(String creatorUid);
    Pin findByCreatorUidAndPinId(String creatorUid, long pinId);
    // You can add custom query methods here if needed
}