package com.example.pencil.xiaobao.data;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({PostType.TYPE_ZHIHU, PostType.TYPE_DOUBAN, PostType.TYPE_GUOKR})
public @interface PostType {

  int TYPE_ZHIHU = 0;

  int TYPE_DOUBAN = 1;

  int TYPE_GUOKR = 2;

}
