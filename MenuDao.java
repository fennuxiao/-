package com.example.health.dao;

import org.springframework.stereotype.Repository;
import com.example.health.bean.MainMenu;
import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();
}
