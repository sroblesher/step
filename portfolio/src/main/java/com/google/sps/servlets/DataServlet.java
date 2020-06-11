// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

  private ArrayList<String> messages;

  @Override
  public void init() {
    messages = new ArrayList<>();
    messages.add("It would only take one hour to drive to space.");
    messages.add("Google's first office was a rented garage.");
    messages.add("Walmart has lower acceptance rate than Harvard.");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String json = convertToJsonUsingGson(messages);

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().print(json);
    response.getWriter().flush();
  }

  private String convertToJsonUsingGson(ArrayList<String> messages) {
    Gson gson = new Gson();
    String json = gson.toJson(messages);
    return json;
  }
}
