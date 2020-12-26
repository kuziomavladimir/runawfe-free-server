package ru.runa.wf.web.ftl.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@Slf4j
class EditUserTypeListTest {

    @Mock
    EditUserTypeList.EditUserTypeListModel editUserTypeListModel;

    @Test
    void optimumGetTemplateValueTest () {
        String result ="wersdfsdf\"sdv\"dsvss\naszxcs[]dvcsdv[dsvds]sdfs{}dsv";
        MockitoAnnotations.initMocks(this);

        when(editUserTypeListModel.optimumGetTemplateValue(result)).thenReturn(result.replaceAll("\"", "'").
                replaceAll("\n", "").replace("[]", "{}"));

        log.info(editUserTypeListModel.optimumGetTemplateValue(result));
    }

}