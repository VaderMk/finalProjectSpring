package org.example.finalproject.repository;

import org.example.finalproject.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
