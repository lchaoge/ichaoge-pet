package com.ichaoge.pet.common;


import com.ichaoge.pet.domain.entity.PetSort;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chaoge on 2018/8/30.
 */
public class MenuPetSortUtil {
    public static Map<String,Object> mapArray = new LinkedHashMap<String, Object>();
    public List<PetSort> menuCommon;
    public List<Object> list = new ArrayList<Object>();

    public List<Object> menuList(List<PetSort> menu){
        this.menuCommon = menu;
        for (PetSort x : menu) {
            Map<String,Object> mapArr = new LinkedHashMap<String, Object>();
            if(x.getParentId()==null){
                mapArr.put("id", x.getId());
                mapArr.put("parentId", x.getParentId());
                mapArr.put("name", x.getName());
                mapArr.put("describes", x.getDescribes());
                mapArr.put("photo", x.getPhoto());
                mapArr.put("childList", menuChild(x.getId()));
                list.add(mapArr);
            }
        }
        return list;
    }

    public List<?> menuChild(Long id){
        List<Object> lists = new ArrayList<Object>();
        for(PetSort a:menuCommon){
            Map<String,Object> childArray = new LinkedHashMap<String, Object>();
            if(a.getParentId() == id){
                childArray.put("id", a.getId());
                childArray.put("parentId", a.getParentId());
                childArray.put("name", a.getName());
                childArray.put("photo", a.getPhoto());
                childArray.put("childList", menuChild(a.getId()));
                lists.add(childArray);
            }
        }
        return lists;
    }
}
