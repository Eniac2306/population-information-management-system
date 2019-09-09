package com.cesec.springboot.system.dao;


import com.cesec.springboot.common.BaseDao;
import com.cesec.springboot.system.entity.*;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * 继承了通用Mapper,建议使用通用Mappe,特殊业务使用注解sql
 */
@Repository
public interface UserInfoDao extends BaseDao<UserInfo> {
	
	@Select("select * from t_people_baseinfo limit 10")
	public List<UserInfo> selectAll();

	//查询登录用户在数据库中是否存在
	@Select("select count(*) from login where user_name = #{userName} and password = #{passWord}")
	public int findUserInfoLogin(String userName,String passWord);





	//身份证模糊查询
	@Select("select a.row_id,a.id_card,a.name,a.sex,a.nation,a.height,a.born_date,a.create_by,a.create_time,a.update_by,a.update_time,c.name as newnation,d.details as newsex,b.ext_value  from t_people_baseinfo a left join t_otherpeople_useinfo b on a.row_id = b.f_row_id left join t_nation c on a.nation = c.id left join t_sex d on a.sex = d.id where id_card like '%${idCard}%' and delete_id = 0")
	public List<UserBaseInfo> getAllByIdCard(@Param("idCard") String idCard);
	//根据row_id查询
	@Select("select a.row_id,a.id_card,a.name,a.sex,a.nation,a.height,a.born_date,a.create_by,a.create_time,a.update_by,a.update_time,c.name as newnation,d.details as newsex,b.ext_value  from t_people_baseinfo a left join t_otherpeople_useinfo b on a.row_id = b.f_row_id left join t_nation c on a.nation = c.id left join t_sex d on a.sex = d.id where a.row_id =#{rowId} and delete_id = 0")
	public UserBaseInfo getAllByRowId(@Param("rowId") int rowId);
	//民族查询
	@Select("select a.row_id,a.id_card,a.name,a.sex,a.nation,a.height,a.born_date,a.create_by,a.create_time,a.update_by,a.update_time,c.name as newnation,d.details as newsex,b.ext_value from t_people_baseinfo a left join t_otherpeople_useinfo b on a.row_id = b.f_row_id left join t_nation c on a.nation = c.id left join t_sex d on a.sex = d.id where nation = #{nation} and delete_id = 0")
	public List<UserBaseInfo> getAllByNation(int nation);


	//姓名与身份证联合查询
	@Select("select a.row_id,a.id_card,a.name,a.sex,a.nation,a.height,a.born_date,a.create_by,a.create_time,a.update_by,a.update_time,c.name as newnation,d.details as newsex ,b.ext_value from t_people_baseinfo a left join  t_otherpeople_useinfo b on a.row_id = b.f_row_id left join t_nation c on a.nation = c.id left join t_sex d on a.sex = d.id where a.name like '%${userName}%' and id_card like '%${idCard}%' and delete_id = 0")
	public List<UserBaseInfo> getAllByNameAndIdCard(String userName,String idCard);

	//姓名模糊查询
	@Select("select a.row_id,a.id_card,a.name,a.sex,a.nation,a.height,a.born_date,a.create_by,a.create_time,a.update_by,a.update_time,c.name as newnation,d.details as newsex,b.ext_value  from t_people_baseinfo a left join  t_otherpeople_useinfo b on a.row_id = b.f_row_id left join t_nation c on a.nation = c.id left join t_sex d on a.sex = d.id where a.name like '%${userName}%'  and delete_id = 0")
	public List<UserBaseInfo> getAllByName(@Param("userName") String userName);

	//姓名与民族联合查询
	@Select("select a.row_id,a.id_card,a.name,a.sex,a.nation,a.height,a.born_date,a.create_by,a.create_time,a.update_by,a.update_time,c.name as newnation,d.details as newsex,b.ext_value  from t_people_baseinfo a left join  t_otherpeople_useinfo b on a.row_id = b.f_row_id left join t_nation c on a.nation = c.id left join t_sex d on a.sex = d.id where a.name like '%${userName}%' and nation = #{nation} and delete_id = 0")
	public List<UserBaseInfo> getAllByNameAndNation(String userName,int nation);

	//身份证与民族联合查询
	@Select("select a.row_id,a.id_card,a.name,a.sex,a.nation,a.height,a.born_date,a.create_by,a.create_time,a.update_by,a.update_time,c.name as newnation,d.details as newsex,b.ext_value  from t_people_baseinfo a left join  t_otherpeople_useinfo b on a.row_id = b.f_row_id left join t_nation c on a.nation = c.id left join t_sex d on a.sex = d.id  where id_card like '%${idCard}%' and nation = #{nation} and delete_id = 0")
	public List<UserBaseInfo> getAllByIdCardAndNation(String idCard,int nation);

	//身份证，姓名和民族联合查询
	@Select("select a.row_id,a.id_card,a.name,a.sex,a.nation,a.height,a.born_date,a.create_by,a.create_time,a.update_by,a.update_time,c.name as newnation,d.details as newsex,b.ext_value from t_people_baseinfo a left join  t_otherpeople_useinfo b on a.row_id = b.f_row_id left join t_nation c on a.nation = c.id left join t_sex d on a.sex = d.id  where a.name like '%${userName}%' and id_card like '%${idCard}%' and nation = #{nation} and delete_id = 0")
	public List<UserBaseInfo> getAllByNameAndIdCardAndNation(String userName,String idCard,int nation);

	//查询所有
	@Select("select a.row_id,a.id_card,a.name,a.sex,a.nation,a.height,a.born_date,a.create_by,a.create_time,a.update_by,a.update_time,c.name as newnation,d.details as newsex,b.ext_value  from t_people_baseinfo a left join t_otherpeople_useinfo b on a.row_id = b.f_row_id left join t_nation c on a.nation = c.id left join t_sex d on a.sex = d.id where delete_id = 0")
	public List<UserBaseInfo> getAll();


	//删除主表的数据
	@Select("update t_people_baseinfo set delete_id = 1 where row_id = #{rowId}")
	public  void deleteUserBaseInfo(@Param("rowId") int rowId);
	//删除从表车辆表的数据
	@Select("update t_car_info set delete_id = 1 where row_id = #{rowId}")
	public  void deleteUserCarInfo(@Param("rowId") int rowId);
	//删除从表职业表的数据
	@Select("update t_career_info set delete_id = 1 where row_id = #{rowId}")
	public  void deleteUserCareerInfo(@Param("rowId") int rowId);
	//删除从表地址表表的数据
	@Select("update t_address_info set delete_id = 1 where row_id = #{rowId}")
	public  void deleteUserAddressInfo(@Param("rowId") int rowId);

	/**
	 *
	 * 徐枫
	 * 数据修改
	 */
	//根据f_row_id查询扩展表字段
	@Select("select * from t_otherpeople_useinfo where f_row_id=#{rowId}")
	public  UserBaseInfo selectByrowid(@Param("rowId")int rowId);
	//修改主表数据
	@Select("update t_people_baseinfo set id_card=#{idCard},name=#{name},sex=#{sex},nation=#{nation},height=#{height},update_by=#{updateBy} where row_id=#{rowId}")
	public void updateUserBaseInfo(@Param("rowId")int rowId,@Param("idCard") String idCard,@Param("name") String name,@Param("sex") int sex, @Param("nation")int nation,@Param("height") int height,@Param("bornDate") Date bornDate,@Param("updateBy") String updateBy);
	//修改主表扩展表
	@Select("update t_otherpeople_useinfo set ext_Value=#{extValue} where f_row_id = #{f_rowId}")
	public void updateUserExInfo(@Param("f_rowId")int f_rowId,@Param("extValue") String extValue);


	//数据新增
	@Select("select max(row_id) as row_id from t_people_baseinfo")
	public UserBaseInfo selectMaxRowId();
	@Select("insert into t_people_baseinfo(row_id,id_card,name,sex,nation,height,born_Date,create_by,update_by,delete_id) values(#{rowId},#{idCard},#{name},#{sex},#{nation},#{height},#{bornDate},'lsl','lsl',0)")
	public void addUserInfo(int rowId,@Param("idCard") String idCard,@Param("name") String name,@Param("sex") int sex, @Param("nation")int nation,@Param("height") int height,@Param("bornDate") Date bornDate);
	@Select("insert into t_otherpeople_useinfo(f_row_id,ext_Value) values(#{f_rowId},#{extValue})")
	public void addUserExInfo(int f_rowId,String extValue);

	//车辆表查询（根据人）
	@Select("select * from t_car_info where f_row_id=#{peopleId} and delete_id=0")
	public List<CarInfo> selectCarByPeopleId(int peopleId);
   //根据车牌和品牌
	@Select("select * from t_car_info where car_number like '%${carNumber}%' and brand like '%${brand}%' and delete_id=0")
	public List<CarInfo> selectCarByCarNumber(String carNumber,String brand);
	//车辆表修改
	@Select("update t_car_info set car_number=#{carNumber},brand=#{brand},model=#{model},color=#{color},price=#{price},buy_date=#{buyDate} where row_id=#{rowId}")
	public void updateCar(int rowId,String carNumber,String brand,String model,String color,Float price,Date buyDate);
   //车辆表增加
   @Select("insert into t_car_info(f_row_id,car_number,brand,model,color,price,buy_date,create_by,update_by,delete_id) values(#{fRowId},#{carNumber},#{brand},#{model},#{color},#{price},#{buyDate},'lsl','lsl',0)")
   public void addCar(int fRowId,String carNumber,String brand,String model,String color,Float price,Date buyDate);




	//地址表查询（根据人）
	@Select("select * from t_address_info where f_row_id=#{peopleId} and delete_id=0")
	public List<AddressInfo> selectAddressByPeopleId(int peopleId);
	//根据地址查询
	@Select("select * from t_address_info where province like '%${province}%' and city like '%${city}%' and area like '%${area}%' and delete_id=0")
	public  List<AddressInfo> selectAddressByAddress(String province,String city,String area);
    //地址表新增
	@Select("insert into t_address_info(f_row_id,province,city,area,details,is_rent,is_resident,create_by,update_by,delete_id) values(#{fRowId},#{province},#{city},#{area},#{details},#{isRent},#{isResident},'lsl','lsl',0)")
	public void addAddress(int fRowId,String province,String city,String area,String details,int isRent,int isResident);
	//地址表修改
	@Select("update t_address_info set province=#{province},city=#{city},area=#{area},details=#{details}, is_rent=#{isRent},is_resident=#{isResident} where row_id=#{rowId}")
	public void updateAddress(int rowId,String province,String city,String area,String details,int isRent,int isResident);





	//职业表查询（根据人）
	@Select("select a.*,b.value as newIndustry from t_career_info a,industry b where a.industry=b.row_id and f_row_id=#{peopleId} and delete_id=0")
	public List<CareerInfo> selectCareerByPeopleId(int peopleId);
	//职业表查询(类型)
	@Select({
			"<script>",
			"select a.*,b.value as newIndustry from t_career_info a,industry b ",
			"<where>",
			"delete_id=0 and a.industry=b.row_id",
			"<if test='industry!=null and industry!=\"\" and industry!=0'>",
			"and industry=#{industry}",
			"</if>",
			"<if test='companyName!=null and companyName!=\"\"'>",
			"and company_name like '%${companyName}%'",
			"</if>",
			"</where>",
			"order by row_id",
			"</script>"
	})
	public  List<CareerInfo> selectCareerByIndustry(int industry,String companyName);
	//职业表新增
	@Select("insert into t_career_info(f_row_id,industry,company_name,job_name,time,create_by,update_by,delete_id) values(#{fRowId},#{industry},#{companyName},#{jobName},#{time},'lsl','lsl',0)")
	public void addCareer(int fRowId,int industry,String companyName,String jobName,float time);
	//职业表修改
	@Select("update t_career_info set industry=#{industry},company_name=#{companyName},job_name=#{jobName},time=#{time} where row_id=#{rowId}")
	public void updateCareer(int rowId,int industry,String companyName,String jobName,float time);



}
