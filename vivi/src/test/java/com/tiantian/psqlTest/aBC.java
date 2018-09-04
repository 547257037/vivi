package com.tiantian.psqlTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.Lists;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author 付天
 * @Title: starv-iptv-4
 * @Package com.starv
 * @Description: ${TODO}
 * @date 2018/4/18 0018下午 9:07
 */
public class aBC {
    static final String formatPattern = "yyyy-MM-dd";
    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
        Date date = new Date();
        date = DateUtils.addDays(date, -1);
        return "\""+sdf.format(date)+":"+sdf.format(date)+"\"";
    }
    public static void main(String[] args) throws ParseException {
//类加载根路径
        String classPath = aBC.class.getResource("").getPath();
        //类所在工程根路径
        String proClassPath = aBC.class.getResource("").getPath();
        //Map<Tuple2<String, String>, List<Tuple2<String, String>>>
        Map<String, Long> collect = Lists.newArrayList(
                new OperatorRoleName("DX", "电信", "1", "root"),
                new OperatorRoleName("DX", "电信", "2", "3333"),
                new OperatorRoleName("LT", "联通", "1", "root"),
                new OperatorRoleName("LT", "联通", "2", "3333"),
                new OperatorRoleName("LT", "联通", "3", "4444")
        ).stream().collect(groupingBy(x -> x.getOperatorCode(), counting()));
        //      .collect(groupingBy(x -> Tuple.of(x.getOperatorCode(), x.getOperatorName()), mapping(x -> Tuple.of(x.getRoleId(), x.getRoleName()), toList())));
        System.out.println(collect);

//        String shandongThroughoutTheDayJson = "{\"dayRange\":"+getCurrentDate()+",\"timeRange\":\"00:00:00-23:59:59\",\"channelGroupCode\":-1,\"channelGroupFlag\":false,\"channelCodeSet\":[\"140\"],\"timeInterval\":\"ONE_MINUTE\",\"dayInterval\":\"NONE\",\"operator\":\"LT\",\"platform\":\"HW\",\"areaCodeSet\":[\"ALL\"],\"programNameSet\":[\"温柔的谎言\", \"温柔的背后\", \"道德与法治\", \"记住乡愁\", \"早安山东\", \"大医本草堂\", \"国士无双黄飞鸿\", \"天气预报\", \"隋唐英雄传\", \"纵横四海\", \"齐鲁先锋\",\"山东新闻联播\",\"中央台新闻联播\",\"国士无双黄飞鸿（27）\",\"国士无双黄飞鸿（28）\",\"最炫国剧风\",\"拜托了妈妈\",\"金婚\",\"晚间新闻\"],\"showProgram\":true,\"programGroupFlag\":false,\"indexSet\":[\"audienceRating\"],\"pageInfo\":{\"page\":1,\"pageMax\":10000,\"total\":0}}";
//        AbstractWebParam webLiveParam = JacksonUtil.jsonToObject(shandongThroughoutTheDayJson, WebLiveParam.class);
//
//        List<String> list3 = Arrays.asList("aa", "bb", "cc", "dd", "ee");
//        list3.stream()
//                .sorted()
//                .forEach(System.out::println);
//List<LiveResult> throughoutTheDayLiveResults = new ArrayList<>();
//        LiveResult liveResult = new LiveResult();
//        liveResult.setPlayTime(1L);
//        liveResult.setAudienceRating(new BigDecimal(0.766));
//        liveResult.setDayRange("叫爸爸");
//        throughoutTheDayLiveResults.add(liveResult);
//
//        LiveResult liveResult1 = new LiveResult();
//        liveResult1.setPlayTime(1L);
//        liveResult1.setAudienceRating(new BigDecimal(0.7610));
//        liveResult1.setDayRange("叫爸爸");
//        throughoutTheDayLiveResults.add(liveResult1);
//        LiveResult liveResul2 = new LiveResult();
//        liveResul2.setPlayTime(1L);
//        liveResul2.setAudienceRating(new BigDecimal(0.798));
//        liveResul2.setDayRange("叫爸爸");
//        throughoutTheDayLiveResults.add(liveResul2);
//        LiveResult liveResul3 = new LiveResult();
//        liveResul3.setPlayTime(1L);
//        liveResul3.setAudienceRating(new BigDecimal(0.767));
//        liveResul3.setDayRange("叫爸爸");
//        throughoutTheDayLiveResults.add(liveResul3);
//
//
//         throughoutTheDayLiveResults.stream().sorted((e2, e1) -> {
//            if (e1.getAudienceRating().toString().equals(e2.getAudienceRating().toString())) {
//                return e1.getDayRange().compareTo(e2.getDayRange());
//            } else {
//                return e1.getAudienceRating().compareTo(e2.getAudienceRating());
//            }
//        }).forEach(System.out::println);
//        System.out.println(   webLiveParam);


//
//     Pattern pattern = Pattern.compile("[:(_]+[0-9]+");
//        String[] titlestrs = pattern.split("我的媳妇是女王");//截取节目名称
//
//        System.out.println(titlestrs[0]+titlestrs[1]);
        Set<String> list = new HashSet<>();

//        list.add("电信");
//
//        list.add("移动");
//        list.add("联通");
//
//
//
//
//        Set<String> linkedHashSet =new LinkedHashSet<>();
//        if (list.contains("联通")){
//            linkedHashSet.add("联通");
//        }
//         if (list.contains("移动")){
//             linkedHashSet.add("移动");
//        }
//         if (list.contains("电信")){
//             linkedHashSet.add("电信");
//        }
//        for(String s:linkedHashSet){
//            System.out.println(s);
//        }
    }


    /**
     * @param dateRange
     *            2015-04-24:2015-04-26
     * @return
     * @throws ParseException
     */
    public static List<String> splitDate(String dateRange) throws ParseException {
        List<String> rs = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar startc = Calendar.getInstance();
        Calendar endc = Calendar.getInstance();
        String[] d = dateRange.split(":");
        startc.setTime(sdf.parse(d[0]));
        endc.setTime(sdf.parse(d[1]));
        Date tmpDate = startc.getTime();
        while (tmpDate.before(endc.getTime()) || tmpDate.getTime() == endc.getTime().getTime()) {
            rs.add(sdf.format(startc.getTime()).replace("-", ""));
            startc.add(Calendar.DATE, 1);
            tmpDate = startc.getTime();
        }
        return rs;
    }

    @Data
    @AllArgsConstructor
    private static class OperatorRoleName {
        private String operatorCode;
        private String operatorName;
        private String roleId;
        private String roleName;

    }
}