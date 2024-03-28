package org.example.finalproject.repository;

import org.example.finalproject.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
