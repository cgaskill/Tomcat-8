package com.credera.controller;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping(value = "/async/{wait}")
	public @ResponseBody
	Callable<String> async(@PathVariable(value="wait") final int wait) {
		return new Callable<String>() {
			public String call() throws Exception {
				try {
					Thread.sleep(wait);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "async";
			}
		};
	}

	@RequestMapping("/sync/{wait}")
	public @ResponseBody
	String sync(@PathVariable(value="wait") int wait) {
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "sync";
	}
}
