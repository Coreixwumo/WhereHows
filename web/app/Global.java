/**
 * Copyright 2015 LinkedIn Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
import play.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import play.Application;
import play.GlobalSettings;
import play.api.mvc.EssentialFilter;
import play.filters.gzip.GzipFilter;

public class Global extends GlobalSettings{

      private ApplicationContext applicationContext;

      public <T extends EssentialFilter> Class<T>[] filters() {
            return new Class[]{GzipFilter.class};
      }

      @Override
      public void onStart(Application arg0) {
            applicationContext = new ClassPathXmlApplicationContext("components.xml");
      }
     
      @Override
      public <A> A getControllerInstance(Class<A> type) throws Exception {
            return applicationContext.getBean(type);
      }
     
}

