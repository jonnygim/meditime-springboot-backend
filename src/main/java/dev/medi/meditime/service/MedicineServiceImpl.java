package dev.medi.meditime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.medi.meditime.dto.MedicineDTO;
import dev.medi.meditime.repository.MedicineRepository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@Service
public class MedicineServiceImpl implements MedicineService {
    
    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public MedicineDTO getMedicine(String itemName, String efcItem) {
            String key = "f4qQWqS9wdQmJx8Oiz6vZzgY5QB3%2BapRkKdTpTUgNNP3R62h%2F3iOfCDFpWbafVEOPsMbjCA5qAFuTiaah1zZsw%3D%3D";

        MedicineDTO result = null;
        try{
            // parsing할 url 지정(API 키 포함해서)
            String url = "http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList?serviceKey="+key +"&trustEntpName=한미약품(주)&pageNo=1&startPage=1&numOfRows=3";

            DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
            Document doc = dBuilder.parse(url);

            // 제일 첫번째 태그
            doc.getDocumentElement().normalize();

            // 파싱할 tag
            NodeList nList = doc.getElementsByTagName("items");

            for(int temp = 0; temp < nList.getLength(); temp++){
                Node nNode = nList.item(temp);

                Element eElement = (Element) nNode;

                System.out.println("회사명 : " + getTagValue("entpName", eElement));
                System.out.println("약명 : " + getTagValue("itemName", eElement));
                System.out.println("효능 : " + getTagValue("efcyQesitm", eElement));
                System.out.println("사용법 : " + getTagValue("useMethodQesitm", eElement));
                System.out.println("주의사항(경고) : " + getTagValue("atpnWarnQesitm", eElement));
                System.out.println("주의사항 : " + getTagValue("atpnQesitm", eElement));
                System.out.println("상호작용 : " + getTagValue("intrcQesitm", eElement));
                System.out.println("부작용 : " + getTagValue("seQesitm", eElement));
                System.out.println("보관법 : " + getTagValue("depositMethodQesitm", eElement));
                System.out.println("낱알이미지 : " + getTagValue("itemImage", eElement));

                result = MedicineDTO.builder()
                        .itemName(getTagValue("itemName", eElement))
                        .entpName(getTagValue("entpName", eElement))
                        .efcItem(getTagValue("efcyQesitm", eElement))
                        .methItem(getTagValue("useMethodQesitm", eElement))
                        .warnItem(getTagValue("atpnWarnQesitm", eElement))
                        .atpnItem(getTagValue("atpnQesitm", eElement))
                        .intrItem(getTagValue("intrcQesitm", eElement))
                        .seItem(getTagValue("seQesitm", eElement))
                        .depoItem(getTagValue("depositMethodQesitm", eElement))
                        .itemImage(getTagValue("itemImage", eElement))
                        .build();
            }

        } catch (Exception e){
            e.printStackTrace();
        }



//        List<Medicine> list = medicineRepository.searchMediList(itemName, efcItem);
//
//        List<MedicineDTO> result = list.stream().map(r -> new MedicineDTO(r)).collect(Collectors.toList());
//        System.out.println(result);
        
        return result;
    
    }

    // tag값의 정보를 가져오는 함수
    public static String getTagValue(String tag, Element eElement) {

        //결과를 저장할 result 변수 선언
        String result = "";

        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();

        result = nlList.item(0).getTextContent();

        return result;
    }

    // tag값의 정보를 가져오는 함수
    public static String getTagValue(String tag, String childTag, Element eElement) {

        //결과를 저장할 result 변수 선언
        String result = "";

        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();

        for(int i = 0; i < eElement.getElementsByTagName(childTag).getLength(); i++) {

            //result += nlList.item(i).getFirstChild().getTextContent() + " ";
            result += nlList.item(i).getChildNodes().item(0).getTextContent() + " ";
        }

        return result;
    }

}
