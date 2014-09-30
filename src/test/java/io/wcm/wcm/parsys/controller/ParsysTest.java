/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2014 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.wcm.parsys.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import io.wcm.testing.mock.aem.junit.AemContext;
import io.wcm.wcm.parsys.controller.Parsys.Item;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.WCMMode;
import com.day.cq.wcm.api.components.Component;
import com.day.cq.wcm.api.components.ComponentContext;

@RunWith(MockitoJUnitRunner.class)
public class ParsysTest {

  private static final String RESOURCE_TYPE_SAMPLE = "/apps/sample/components/parsys";

  @Rule
  public AemContext context = new AemContext();

  @Mock
  private ComponentContext componentContext;
  @Mock
  private Component component;

  private Resource parsysResource;
  private Resource par1Resource;
  private Resource par2Resource;

  @Before
  public void setUp() {
    context.request().setAttribute(ComponentContext.CONTEXT_ATTR_NAME, componentContext);
    when(componentContext.getComponent()).thenReturn(component);
    when(component.getPath()).thenReturn(RESOURCE_TYPE_SAMPLE);

    Page page = context.create().page("/content/page1", "/apps/sample/templates/test1");
    parsysResource = context.create().resource(page.getContentResource().getPath() + "/parsys");
    par1Resource = context.create().resource(parsysResource.getPath() + "/par1");
    par2Resource = context.create().resource(parsysResource.getPath() + "/par2");
    context.currentResource(parsysResource);
  }

  @Test
  public void testEditMode() {
    WCMMode.EDIT.toRequest(context.request());
    Parsys parsys = context.request().adaptTo(Parsys.class);

    List<Item> items = parsys.getItems();
    assertEquals(3, items.size());

    Item item1 = items.get(0);
    assertEquals(par1Resource.getPath(), item1.getResourcePath());
    assertNull(item1.getResourceType());
    assertEquals(Parsys.DECORATION_TAG_NAME, item1.getDecorationTagName());
    assertNull(item1.getCssClassName());
    assertFalse(item1.isNewArea());

    Item item2 = items.get(1);
    assertEquals(par2Resource.getPath(), item2.getResourcePath());
    assertNull(item2.getResourceType());
    assertEquals(Parsys.DECORATION_TAG_NAME, item2.getDecorationTagName());
    assertNull(item2.getCssClassName());
    assertFalse(item2.isNewArea());

    Item item3 = items.get(2);
    assertEquals(Parsys.NEWAREA_RESOURCE_PATH, item3.getResourcePath());
    assertEquals(RESOURCE_TYPE_SAMPLE + Parsys.NEWAREA_RESOURCE_TYPE_SUFFIX, item3.getResourceType());
    assertEquals(Parsys.DECORATION_TAG_NAME, item3.getDecorationTagName());
    assertEquals(Parsys.NEWAREA_CSS_CLASS_NAME, item3.getCssClassName());
    assertTrue(item3.isNewArea());
  }

  @Test
  public void testWcmDisabledMode() {
    WCMMode.DISABLED.toRequest(context.request());
    Parsys parsys = context.request().adaptTo(Parsys.class);

    List<Item> items = parsys.getItems();
    assertEquals(2, items.size());

    Item item1 = items.get(0);
    assertEquals(par1Resource.getPath(), item1.getResourcePath());
    assertNull(item1.getResourceType());
    assertEquals(Parsys.DECORATION_TAG_NAME, item1.getDecorationTagName());
    assertNull(item1.getCssClassName());
    assertFalse(item1.isNewArea());

    Item item2 = items.get(1);
    assertEquals(par2Resource.getPath(), item2.getResourcePath());
    assertNull(item2.getResourceType());
    assertEquals(Parsys.DECORATION_TAG_NAME, item2.getDecorationTagName());
    assertNull(item2.getCssClassName());
    assertFalse(item2.isNewArea());
  }

}
