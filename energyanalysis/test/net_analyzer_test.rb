=begin
This file is part of SmartDiet.

Copyright (C) 2011, Aki Saarinen.

SmartDiet was developed in affiliation with Aalto University School 
of Science, Department of Computer Science and Engineering. For
more information about the department, see <http://cse.aalto.fi/>.

SmartDiet is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
 
SmartDiet is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with SmartDiet.  If not, see <http://www.gnu.org/licenses/>.
=end
require File.dirname(__FILE__) + '/helper.rb'
require_src 'net_analyzer'

class NetAnalyzerTest < Test::Unit::TestCase
  def setup
    @reader = NetAnalyzer.new(testfile_path("5k"))
  end

  def test_method_and_packet_count
    assert_equal 5000, @reader.all_methods.size
    assert_equal 106, @reader.packets.size
  end
end
