package com.rujira.recyclerviewgoogleplay.Interface;

import com.rujira.recyclerviewgoogleplay.Model.ItemGroup;

import java.util.List;

public interface IFirebaseLoadListener {
    void onFirebaseLoadSuccess(List<ItemGroup> itemGroupList);
    void onFirebaseLoadFailed(String message);
}
