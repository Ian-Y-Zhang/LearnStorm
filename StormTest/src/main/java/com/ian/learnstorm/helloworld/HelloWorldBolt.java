package com.ian.learnstorm.helloworld;

import java.util.Map;

import org.apache.log4j.Logger;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

public class HelloWorldBolt extends BaseRichBolt {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5389328770560210031L;
	private static Logger LOG = Logger.getLogger(HelloWorldBolt.class);
	private int myCount = 0;
	
	public void execute(Tuple input) {
		String test = input.getStringByField("sentence");
		if (test.equals("Hello World")){
			myCount++;
			System.out.println("Found a Hello world");
			LOG.debug("Found a Hello world");
		}
	}

	public void prepare(Map conf, TopologyContext context, OutputCollector collector) {

	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("myCount"));
	}

}
