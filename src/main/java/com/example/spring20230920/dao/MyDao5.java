package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto36;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

// 동적 쿼리
@Mapper
public interface MyDao5 {
// if
    @Select("""
            <script>
                SELECT COUNT(*)
                FROM customers
                
                <if test='country != null'>
                WHERE Country = #{country}
                </if>
            </script>
            """)
    String select1(String country);

    @Select("""
            <script>
                SELECT CustomerName 
                FROM customers
                
                <if test='num == 10'>
                    -- 수가 10 이다. if 안에 넣을때는 그냥 넣으면된다
                </if>
                <if test= 'num != 10'>
                    -- 수가 10이 아니다 
                </if>
                <if test = 'num > 10'>
                    -- 수가 10보다 크다
                </if>
                <if test = 'num lt 10'>
                    -- 수가 10 보다 작다
                </if>
                <if test='num >= 10'>
                    -- 수가 10보다 크거나 같다
                </if>
                <if test = 'num lte 10'>
                    -- 수가 10보다 작거나 같아.
                </if>
            </script>
            """)
    // < 작다는 쓸수없다. lt로 바꿔서 써야한다.(키워드 연산을 써야한다)
    // <= 요고 대신 lte 작거나 같다
    List<String> select2(Integer num);

    @Select("""
            <script>
                SELECT CustomerName,
                       ContactName
                FROM customers
                <if test ='code == 1'>
                WHERE CustomerName LIKE #{k}
                </if>
                 <if test ='code == 2'>
                WHERE ContactName LIKE #{k}
                </if>
            </script>
            """)
    List<Map<String,Object>> select3(Integer code, String k);

    @Select("""
            <script>
                SELECT COUNT(*)
                FROM customers
                WHERE 
                    <if test='i gt 10'>
                        -- i 가 10보다 큼
                    </if>
                    <if test='i lt 10'>
                        -- i가 10 보다 작음
                    </if>
                    <if test='(i gt 0) and (i lt 100)'>
                        -- i가 0보다 크고 100보다 작다
                    </if>
            </script>
            """)
    String select4(int i);

    // 쿼리 자체에 >, < 기호가 있다면? 쿼리가 동적으로 만들어진다면
    @Select("""
            SELECT *
            FROM customers
            WHERE CustomerName > 'a';
            """)
    String select5();

    // CDATA : 안에 어떤 기호를 쓰더라도 태그로 인식하지 말아라!
    // 문자로만 판단, 마크업 코드로 해석 하지 말라
    @Select("""
            <script>
                <![CDATA[
                    SELECT *
                    FROM customers
                    WHERE CustomerName < 'a';
                ]]>
            </script>
            """)
    // < 태그에 일부분으로 인식해서 text로 인식을 해달라 하는 기호가 < ![CDATA]
    String select6();

    // 포 이치~
    @Select("""
            <script>
                SELECT * 
                FROM customers
                WHERE 
                    Country IN
                    <foreach collection="args" 
                             item="elem" 
                             separator=","
                             open="("
                             close=")">
                    #{elem}
                    </foreach>
                    
            </script>
            """)

   String select7(List args);

    // 동적 쿼리를 하다 보면 불필요한 코드가 있다.
    // trim prefixOverrides="OR" 맨앞에 있다면 지워야하는 코드
    @Select("""
        <script>
        SELECT * 
        FROM customers
            <trim prefix="WHERE" prefixOverrides="OR">
                <foreach collection="args"
                         item="elem">
                    OR country = #{elem}
                </foreach>
            </trim>
        </script>
        """)
    String select8(List args);

    // bind
    // 안쪽에 큰 따옴표 쓰면 밖에 작은따옴표
    // "' ' "  , ' " " ' 요롷게 써라
    @Select("""
            <script>
            <bind name="allterKeyword" value="'%' + keyword + '%'" />
            SELECT *
            FROM customers
            WHERE CustomerName LIKE #{allterKeyword}
            </script>
            """)
    String select9(String keyword);

    @Select("""
            <script>
                SELECT *
                FROM customers
                WHERE
                    <if test="word == 'abc'">
                        -- word는 abc
                    </if>
                    <if test='word == "def"'>
                        -- word는 def
                    </if>
                    <if test="word == 'q'">
                        -- word는 qq
                    </if>
                    <if test='word == "k"'>
                        -- word는 k
                    </if>
            </script>
            """)
    // 한글자는 캐릭터는 ' ' 작은 따옴표를 써야한당
    // 많은 경우에 ' " " ' 이경우가 아니면 선생님도움받기

    String select10(String word);

    @Select("""
            SELECT DISTINCT City
            FROM customers
            WHERE City IS NOT  NULL AND  City !=''
            ORDER BY 1
            """)
    List<String> listCustomerCity();

    @Select("""
            SELECT DISTINCT Country
            FROM customers
            WHERE Country IS NOT NULL AND Country != ''
            ORDER BY 1 
            """)
    List<String> listCustomercountry();

    // trim 앞에 키워드를 붙이거나 삭제 할때 사용
    @Select("""
            <script>
            SELECT CustomerName name,
                  City, Country
            FROM Customers
            
            <trim prefix="WHERE"> 
                <if test='type == "1"'>
                    city 
                    <foreach collection="city" item="elem" 
                     open="IN ("
                     separator = ","
                     close=")">
                     #{elem}
                     </foreach>
                </if>
                <if test='type == "2"'> 
                    country
                    <foreach collection="country" item="elem"
                    open=" IN ("
                    separator = ","
                    close=")">
                    #{elem}
                    </foreach>
                </if>
             </trim>   
            ORDER BY name, country, city
            </script>
                
            """)
    List<Map<String,Object>> listCustomer(MyDto36 dto);
}
