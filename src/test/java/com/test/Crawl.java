package com.test;

/**
 * Created by jaylee on 15-4-26.
 */

import java.io.IOException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.*;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Crawl {

    /**
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException {
        testHtmlUnit();
        //testJsoup();
    }

    public static void testJsoup() {

        String url = "http://stockpage.10jqka.com.cn/600000/";
        long start = System.currentTimeMillis();
        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; rv:22.0) Gecko/20100101 Firefox/22.0").ignoreContentType(true).timeout(30000).get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Time is:"
                    + (System.currentTimeMillis() - start) + "ms");
        }

        //股票行情数据
        String stockHq = "ul.detail_list";
        Elements elemHq = doc.select(stockHq);
        System.out.println("股票行情：" + elemHq.text());

        // 公司简介
        String companyDetails = "dl.company_details dd";
        Elements elem = doc.select(companyDetails);
        System.out.println("上市日期：" + elem.get(0).text());
        System.out.println("主营业务：" + elem.get(1).text());
        System.out.println("业务详细：" + elem.get(2).text());
        System.out.println("总股本：" + elem.get(3).text());
        System.out.println("流通股：" + elem.get(4).text());
        System.out.println("营业收入增长率：" + elem.get(5).text());
        System.out.println("营业收入：" + elem.get(6).text());
        System.out.println("净利润：" + elem.get(7).text());
        System.out.println("净利润增长率：" + elem.get(8).text());
        System.out.println("每股收益：" + elem.get(9).text());
        System.out.println("每股净资产：" + elem.get(10).text());
        System.out.println("净资产收益率：" + elem.get(11).text());
        System.out.println("每股现金流：" + elem.get(12).text());
        System.out.println("每股公积金：" + elem.get(13).text());
        System.out.println("每股未分配利润：" + elem.get(14).text());

        String companyDetails2 = "table.gsjj-table td";
        Elements elem2 = doc.select(companyDetails2);
        System.out.println("公司名称：" + elem2.get(1).text());
        System.out.println("所属地域：" + elem2.get(3).text());
        System.out.println("涉及概念：" + elem2.get(5).text());
        System.out.println("所属行业：" + elem2.get(7).text());

        System.out.println("======================十大股东======================");
        //十大股东
        String companyDetails3 = "div.sub_cont_4[stat=gegugp_sdltgd] tr";
        Elements elem10Gd = doc.select(companyDetails3);
        for (Element ele : elem10Gd) {
            String query = "td";
            Elements tdElem = ele.select(query);
            if (tdElem.size() > 0) {
                System.out.println("机构名称：" + tdElem.get(0).text());
                System.out.println("股份类型：" + tdElem.get(1).text());
                System.out.println("持股数（万）：" + tdElem.get(2).text());
                System.out.println("占流通股本比例：" + tdElem.get(3).text());
                System.out.println("环比增减(万)：" + tdElem.get(4).text());
            }
        }
    }

    public static void testHtmlUnit() {
        String pageXml = "";
        try {
            /**HtmlUnit请求web页面*/
            WebClient wc = new WebClient();
            wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true
            wc.getOptions().setCssEnabled(false); //禁用css支持
            wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常
            wc.getOptions().setTimeout(10000); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待
            HtmlPage page = null;
            page = wc.getPage("http://stockpage.10jqka.com.cn/600000/");
            pageXml = page.asXml(); //以xml的形式获取响应文本
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**jsoup解析文档*/
        Document doc = Jsoup.parse(pageXml, "http://stockpage.10jqka.com.cn/600000/");

        String stockHq = "ul.detail_list";
        Elements elemHq = doc.select(stockHq);
        System.out.println("股票行情：" + elemHq.text());
    }
}