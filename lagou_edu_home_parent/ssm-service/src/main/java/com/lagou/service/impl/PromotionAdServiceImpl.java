package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionAdMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    @Override
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO) {

        //进行分页
        PageHelper.startPage(promotionAdVO.getCurrentPage(),promotionAdVO.getPageSize());
        //查询所有
        List<PromotionAd> allPromotionAdByPage = promotionAdMapper.findAllPromotionAdByPage();
        //封装分页
        PageInfo<PromotionAd> pageInfo = new PageInfo<>(allPromotionAdByPage);

        return pageInfo;
    }

    @Override
    public void savePromotionAd(PromotionAd promotionAd) {

        //1.补全信息
        Date date = new Date();
        promotionAd.setCreateTime(date);
        promotionAd.setUpdateTime(date);
        //2.调用方法
        promotionAdMapper.savePromotionAd(promotionAd);
    }

    @Override
    public PromotionAd findPromotionAdById(int id) {
        PromotionAd promotionAdById = promotionAdMapper.findPromotionAdById(id);
        return promotionAdById;
    }

    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {
        //1.补全信息
        promotionAd.setUpdateTime(new Date());
        //2.调用方法
        promotionAdMapper.updatePromotionAd(promotionAd);
    }

    @Override
    public void updatePromotionAdStatus(int id, int status) {

        //1.封装数据
        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setUpdateTime(new Date());
        promotionAd.setStatus(status);
        promotionAd.setId(id);
        //2.调用方法
        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }
}
