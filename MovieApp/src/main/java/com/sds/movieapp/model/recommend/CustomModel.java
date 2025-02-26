package com.sds.movieapp.model.recommend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericItemPreferenceArray;
import org.apache.mahout.cf.taste.impl.model.GenericPreference;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;

import com.sds.movieapp.domain.CommentsDoc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class CustomModel {
	private DataModel dataModel;
	
	public CustomModel(int member_idx, List<CommentsDoc> commentsList) {
		//Map<Long, List<GenericPreference>> preferMap = new HashMap();
		List<GenericPreference> preferList = new ArrayList();
		for(CommentsDoc commentsDoc: commentsList) {
			GenericPreference prefer = null;
			prefer = new GenericPreference(commentsDoc.getMember_idx(), commentsDoc.getMovie_idx(), commentsDoc.getScore());
			preferList.add(prefer);
		}
		//preferMap.put((long)member_idx, preferList);
		FastByIDMap<PreferenceArray> userData = new FastByIDMap();
		userData.put(member_idx, new GenericUserPreferenceArray(preferList));
		dataModel = new GenericDataModel(userData);
	}
}
