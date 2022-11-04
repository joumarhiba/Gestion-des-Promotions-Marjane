package com.marjane.dao;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class ChefRayonDaoTest {

    @Test
    public void main() throws ParseException {

    ChefRayonDaoTest chefRayonDaoTest = new ChefRayonDaoTest();
    chefRayonDaoTest.testUpdateP();
    chefRayonDaoTest.testGetP();
    }
    @Test
    public  void testUpdateP(){
        ChefRayonDao chefRayonDao = new ChefRayonDao();
        assertEquals("La promotion est appliquée mnt !!!!!", chefRayonDao.updatePromo(23));
    }

    @Test
    public void testGetP() throws ParseException {

        DateFormat formatter = new SimpleDateFormat("HH:mm");
        String testTime = formatter.format(new Date());
        Date date1=new SimpleDateFormat("HH:mm").parse(testTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.DATE, 1);

        ChefRayonDao chefRayonDao = new ChefRayonDao();
     //   assertEquals("The statics of promotions not displayed , time out !", chefRayonDao.getPromotions(cal.getTime()));
    }


}