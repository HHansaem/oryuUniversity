<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<table class="table">
	<thead>
		<tr>
			<th colspan="9">
				<div class="d-flex justify-content-end">
					<div class="d-flex col-md-5">
							<input type="hidden" name="lecCd" value="${lecCd}"/>
							<select class="form-select" name="attsWeek" value="${attendanceList[0].attsWeek}">
								<option value>주차선택</option>
								<c:forEach begin="1" end="16" varStatus="cnt">
									<c:choose>
										<c:when test="${cnt.index == 1 and attsWeek == null}">
											<option value="${cnt.index}" selected>${cnt.index}주차</option>
										</c:when>
										<c:when test="${cnt.index == attsWeek}">
											<option value="${cnt.index}" selected>${cnt.index}주차</option>
										</c:when>
										<c:otherwise>
											<option value="${cnt.index}">${cnt.index}주차</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
							<select class="form-select" name="attsSche" value="${attendanceList[0].attsSche}">
								<option value>교시선택</option>
								<c:forEach items="${lectureSchedule}" var="schedule" varStatus="scheCnt">
									<c:choose>
										<c:when test="${scheCnt.index == 0 and attsSche == null}">
											<option value="${schedule.scheCd}" selected>${schedule.scheCd}교시</option>
										</c:when>
										<c:when test="${schedule.scheCd == attsSche}">
											<option value="${schedule.scheCd}" selected>${schedule.scheCd}교시</option>
										</c:when>
										<c:otherwise>
											<option value="${schedule.scheCd}">${schedule.scheCd}교시</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
							<input type="button" class="btn btn-info" value="검색하기" onclick="getAttendanceList()" style="color:white;"/>
					</div>
				</div>
			</th>
		</tr>
		<tr class="custom-color">
			<th colspan="9" class="text-center" id="scheText">0주차 0요일 0교시</th>
		</tr>
		<tr>
			<th class="text-center">
				학번
			</th>
			<th class="text-center">
				이름
			</th>
			<th class="text-center">
				학과
			</th>
			<th class="text-center">출석일수</th>
			<th class="text-center">결석일수</th>
			<th class="text-center">지각일수</th>
			<th colspan="3" class="text-center">
				<span>출석상태</span>
			</th>
		</tr>
	</thead>
	<tbody>
			<c:forEach items="${attendanceList}" var="attendance" varStatus="cnt">
			
			<tr>
				<td class="text-center custom-Font">
					<input type="hidden" name="stCd" value="${attendance.stCd}"/>
					${attendance.stCd}
				</td>
				<td class="text-center custom-Font">
					<input type="hidden" name="stNm" value="${attendance.stNm}"/>
					${attendance.stNm}
				</td>
				<td class="text-center custom-Font">
					<input type="hidden" name="dtNm" value="${attendance.dtNm}"/>
					${attendance.dtNm}
				</td>
				<td class="text-center">
					<input type="hidden" name="atteDays" value="${attendance.atteDays}"/>
					<c:if test="${attendance.atteDays == null}">0</c:if>
					${attendance.atteDays}
				</td>
				<td class="text-center">
					<input type="hidden" name="atteAbseDays" value="${attendance.atteAbseDays}"/>
					<c:if test="${attendance.atteAbseDays == null}">0</c:if>
					${attendance.atteAbseDays}
				</td>
				<td class="text-center">
					<input type="hidden" name="atteTardDays" value="${attendance.atteTardDays}"/>
					<c:if test="${attendance.atteTardDays == null}">0</c:if>
					${attendance.atteTardDays}
				</td>
				<td colspan="3">
					<div class="d-flex justify-content-center data">
						<input type="hidden" name="attCd" value="${attendance.attCd}"/>
						<div class="form-check form-check-inline">
							<input type="hidden" name="attsCd" value="${attendance.attsCd}"/>
							<input class="form-check-input" type="radio" name="attsState${cnt.index}" value="present"
							<c:if test="${attendance.attsState == 'present'}">checked</c:if>
							/>
							<label class="form-check-label custom-Font">출석</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="attsState${cnt.index}" value="late"
							<c:if test="${attendance.attsState == 'late'}">checked</c:if>
							/>
							<label class="form-check-label custom-Font">지각</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="attsState${cnt.index}" value="absent"
							<c:if test="${attendance.attsState == 'absent'}">checked</c:if>
							/>
							<label class="form-check-label" style="font-size:17px;">결석</label>
							</div>
						</div>
					</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="9">
						<div class="d-flex justify-content-end">
							<input type="button" class="btn btn-primary" value="전체 출석" onclick="totalChecked()"/>
							<input type="button" class="btn btn-primary ml-3" value="저장하기" onclick="saveAttendance()"/>
						</div>
					</td>
				</tr>
		</tbody>
	</table>
