package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport reportText = new TextReport();
        TextReport reportHtml = new HtmlReport();
        TextReport reportJson = new JSONReport();
        String text = reportText.generate("Report's name", "Report's body");
        String html = reportHtml.generate("Report's name", "Report's body");
        String json = reportJson.generate("Report's name", "Report's body");
        System.out.println(text);
        System.out.println();
        System.out.println(html);
        System.out.println();
        System.out.println(json);
    }
}
