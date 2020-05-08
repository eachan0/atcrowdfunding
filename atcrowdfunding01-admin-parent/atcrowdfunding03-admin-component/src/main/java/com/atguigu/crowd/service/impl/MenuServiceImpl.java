package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.MenuEntity;
import com.atguigu.crowd.mapper.MenuMapper;
import com.atguigu.crowd.service.MenuService;
import com.atguigu.crowd.util.Result;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhuyc
 * @since 2020-05-07
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {

    @Override
    public Result<MenuEntity> treeMenu() {
        AtomicReference<MenuEntity> menu = new AtomicReference<>();
        List<MenuEntity> list = this.list();
        Map<Integer, MenuEntity> menuMap = list.stream().collect(Collectors.toMap(MenuEntity::getId, v -> v, (k1, k2) -> k2));
        list.forEach(x -> {
            if (x.getPid() == null) {
                menu.set(x);
                return;
            }
            MenuEntity entity = menuMap.get(x.getPid());
            entity.getChildren().add(x);
        });
        return Result.success(menu.get(), 0L);
    }
}
