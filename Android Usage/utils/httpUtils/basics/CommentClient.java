package com.tonyjiang.tourismserverdemo.utils.httpUtils.basics;

import com.tonyjiang.tourismserverdemo.model.Comment;

/**
 * Created by TonyJiang on 2016/3/26.
 */
public interface CommentClient {
    public void AddComment(Comment comt);
    public void DeleteComment(Comment comt);
    public void ListComment(Comment comt);
}
