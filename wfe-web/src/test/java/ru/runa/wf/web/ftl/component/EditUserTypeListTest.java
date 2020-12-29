package ru.runa.wf.web.ftl.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@Slf4j
class EditUserTypeListTest {

    @Mock
    EditUserTypeList.EditUserTypeListModel editUserTypeListModel;

    @Test
    void optimumGetTemplateValueTest () {
        String result ="whsrsdfsdf\"sdv\"dsvss\naszxcs[]dvcsdv[dsvds]sdfs{}dsv";
        MockitoAnnotations.initMocks(this);


        Pattern pattern = Pattern.compile("[[\"][\n][\\[\\]]]");
        System.out.println(pattern);
        Matcher matcher = pattern.matcher(result);
        result = matcher.replaceAll("'");
        System.out.println(result);

        when(editUserTypeListModel.optimumGetTemplateValue(result)).thenReturn(result.replaceAll("(\")(\\n)([\\[][]])", "'"));
//                replaceAll("\n", "").replace("[]", "{}"));

        log.info(editUserTypeListModel.optimumGetTemplateValue(result));
    }

}